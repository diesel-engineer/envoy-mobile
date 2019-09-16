#!/usr/bin/env bash

set -e

ENVOY_FORMAT_ACTION="$1"
if [ -z "$ENVOY_FORMAT_ACTION" ]; then
  echo "No action specified, defaulting to check"
  ENVOY_FORMAT_ACTION="check"
fi

# TODO(mattklein123): WORKSPACE is excluded due to warning about @bazel_tools reference. Fix here
#                     or in the upstream checker.
envoy/tools/check_format.py $ENVOY_FORMAT_ACTION $ENVOY_FORMAT_OPTIONS
envoy/tools/format_python_tools.sh check
