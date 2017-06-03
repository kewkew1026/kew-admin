#/bin/bash
if [ -n "$2" ];then
  echo "\033[31m cd $2 \033[0m"
  cd "$2"
fi
if [ -n "$1" ];then
  echo "\033[31m change version to [$1] \033[0m"
	mvn versions:set -DnewVersion=$1
	mvn versions:update-child-modules
	mvn versions:commit
fi
