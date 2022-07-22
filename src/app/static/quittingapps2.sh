#!/bin/bash
#
#       AUTHOR: Michele Corcione
#       FILE:   distractoff.sh
#       DESCRIPTION: a parental control

function printBanner () {

echo " _____   _                                _____   ___  ___ "                                
echo "(____ \ (_)     _                     _   / ___ \ / __)/ __)"
echo "_    \ \ _  ___| |_   ____ ____  ____| |_| |   | | |__| |__ " 
echo "| |   | | |/___)  _) / ___) _  |/ ___)  _) |   | |  __)  __)" 
echo "| |__/ /| |___ | |__| |  ( ( | ( (___| |_| |___| | |  | |   "
echo "|_____/ |_(___/ \___)_|   \_||_|\____)\___)_____/|_|  |_|   "

}

echo "Welcome in DistractOff app disabler for MacOs "

if [ "$1" != "" ]; then
    printBanner
    echo "Scan started...Searching for $1"
else
    printBanner
    echo ""
    echo "Please insert arguments: <app_name> <nHours> "
    exit
fi

name="$1"
timez="$2"

function processOff () {

  eNd=$(date -v+${timez}H)

  while [ "$(date)" != "$eNd" ]
        do
         #echo "$pids PIDs found" 
          pids=$(pgrep $name)

          if [ -z "$pids" ]
            then
              #echo "waiting for $1..."
              sleep 1  
          else      
              echo $$ > myShell.pid
              kill -9 $pids

          fi

   done

}

case $1 in

  Firefox.app)

      	name="firefox"
	processOff	       
      ;;

  WhatsApp.app)

      	name="WhatsApp"
	processOff
      ;;

  Discord.app)
        
	name="Discord"        
	processOff
        ;;

  *)
    echo "Unknown app: please select an app supported"
    ;;
esac


#ps aux > out.txt
#grep $1 out.txt > line.txt

#input="./line.txt"

#while IFS= read -r line
#  do
#    echo "$line"
#
#done < "$input"

#gcc test.c -o exec
#./exec $1 $2
