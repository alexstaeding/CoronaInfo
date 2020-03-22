#!/bin/bash
set -e

python /coronainfo/coronainfo/app.py

exec "$@"