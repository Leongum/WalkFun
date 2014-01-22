#!/bin/bash
#set -x
_remote_username="root"
_remote_default_password="root"
_remote_ip=""
_remote_default_ssh_username=""


## Function
# run ssh remote cmd
function run_ssh_remote_cmd(){
    sshpass -p ${_remote_default_password} ssh -o StrictHostKeyChecking=no ${_remote_default_ssh_username} $1
    echo ""
}

# upload file -r
function run_scp_cmd_r(){
    echo copy $1 to $2
    sshpass -p ${_remote_default_password} scp -r -o StrictHostKeyChecking=no $1 "${_remote_default_ssh_username}:$2"
}


# get all parameters from cmd
function get_params(){
    # get this script full path
    _app_root_path=` pwd .`

    # check have parameter or no
    if [[ $# -eq 2 ]]; then
        _remote_ip=$1
        _remote_default_password=$2
    else
        print_help
    fi
}

# check parameters
function check_params(){

   # check remote ip null or empty
   if [[ -z $_remote_ip ]]; then
       check_task_status 1 "Error for checking parameter, the remote ip must be provided."
   fi

   # check ip format
   if [ $(expr "$_remote_ip" : '^[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}$') == '0' ]; then
       check_task_status 1 "Error for checking parameter, the remote ip format is invalid."
   fi


   # Split the string into an array
   OLD_IFS="$IFS"
   IFS="."
   arr=($_remote_ip)
   IFS="$OLD_IFS"

   # check ip value
    for s in ${arr[@]}
       do
           if [[ $s -lt 0 ]] | [[ $s -gt 255 ]]; then
               check_task_status 1 "Error for checking parameter, the remote ip namber must be in 0-255."
           fi
    done
}

# print help
function print_help(){
    echo "Please provide remote ip (e.g.10.62.34.5) and password"
    echo "Usage: ./deploy.sh xx.xx.xx.xx password"
    exit 1
}

# check any cmd status: if the first parameter is not "0", print second parameter's error message and exit script.
function check_task_status(){
    if [[ $1 != "0" ]]; then
       echo  $2
       exit 1
    fi
}

function deploy(){
    _remote_default_ssh_username=${_remote_username}@${_remote_ip}
    #chmod u+rx ${_app_root_path}/WEB-INF/upload/ > /dev/null 2>&1
    #chmod u+rx *.sh > /dev/null 2>&1
    echo Copying files to remote 1box ...
    run_scp_cmd_r "${_app_root_path}/WEB-INF/upload/*.jar" "/usr/local/tomcat/webapps/ROOT/WEB-INF/lib/"
    check_task_status $?
    run_scp_cmd_r "${_app_root_path}/WEB-INF/*.xml" "/usr/local/tomcat/webapps/ROOT/WEB-INF/"
    check_task_status $?
    run_scp_cmd_r "${_app_root_path}/css/*.css" "/usr/local/tomcat/webapps/ROOT/css/"
    check_task_status $?
    run_scp_cmd_r "${_app_root_path}/js/*.js" "/usr/local/tomcat/webapps/ROOT/js/"
    check_task_status $?
    run_scp_cmd_r "${_app_root_path}/images/*.*" "/usr/local/tomcat/webapps/ROOT/images/"
    check_task_status $?
    run_scp_cmd_r "${_app_root_path}/index.html" "/usr/local/tomcat/webapps/ROOT/"
    check_task_status $?

    echo Waiting for remote 1box to finish deploying ...
    echo Shutdown Old service ...
    run_ssh_remote_cmd "/usr/local/tomcat/bin/shutdown.sh"
    check_task_status $?
    echo Start up New service ...
    run_ssh_remote_cmd "/usr/local/tomcat/bin/startup.sh"
    check_task_status $?
    _remote_default_ssh_username=${_remote_username}@${_remote_ip}
}

function main(){
    # get ip address as input
    get_params $@;

    # check ip address is valid ip4 address
    check_params;

    # deploy tomcat files
    deploy;
}

# run app
main $@