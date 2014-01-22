package com.usavich.common.lib;

import com.usavich.common.cryptoservice.CryptoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigurationService extends PropertyPlaceholderConfigurer implements InitializingBean {
    private static final String ENCRYPTED_SUFFIX = ".encrypted";

    private CryptoService cryptoService;
    private String[] propertiesFiles;

    public void setCryptoService(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    public void setPropertiesFiles(String[] propertiesFiles) {
        this.propertiesFiles = propertiesFiles;
    }

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties result = super.mergeProperties();

        Assert.state(cryptoService != null);
        for (Object keyObject : new CopyOnWriteArraySet<Object>(result.keySet())) {
            if (!(keyObject instanceof String)) {
                continue;
            }

            String key = (String) keyObject;
            // only decrypt encrypted property value
            if (!key.endsWith(ENCRYPTED_SUFFIX)) {
                continue;
            }

            // truncate key suffix
            String truncatedKey = key.substring(0, key.length() - ENCRYPTED_SUFFIX.length());

            // get decrypted data
            String rawValue = result.getProperty(key);
            String decryptedValue = cryptoService.decrypt(rawValue);

            // replace original property entry
            result.put(truncatedKey, decryptedValue);
            result.remove(keyObject);
        }

        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (propertiesFiles == null || propertiesFiles.length == 0) {
            return;
        }

        Resource[] resources = new FileSystemResource[propertiesFiles.length];
        for (int i = 0; i < propertiesFiles.length; i++) {
            // failed to load this properties file as ClassPathResource,  load as FilesystemResource as workaround
            resources[i] = new FileSystemResource(Constants.CATALINA_ROOT + "/" + propertiesFiles[i]);
        }

        setLocations(resources);
    }
}

