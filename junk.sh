#!/bin/bash

case $1 in
  -l)
    ls ~/.junk
    ;;

  -p)
    rm ~/.junk/*
    ;;

  *)
    if [ ! -d ~/.junk ]; then
      mkdir ~/.junk
    fi

    for file in $@
    do
      mv $file  ~/.junk/$file
    done
esac

