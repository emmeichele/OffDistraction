#!/bin/bash

pid="$1"
kill -9 $pid

rm -rf myShell.pid
