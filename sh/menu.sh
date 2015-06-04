#!/bin/bash
printf "Do you want to see the menu?"
read answer
if [[ $answer == "yes" ]]
then
    cat <<   EOF
    1)Steak and eggs
    2)Fruit and Yogurt
    3)Pie and icecream
EOF
    echo "Pick one:"
    read choice
    case "$choice" in
        1)printf "Cholesterol\n"
            ;;
        2)printf "Dieter\n"
            ;;
        3)printf "Sweet tooth\n"
            ;;
    esac

else
    printf "Later alligator!\n"
fi
