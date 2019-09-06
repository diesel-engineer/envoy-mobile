licenses(["notice"])  # Apache 2

load("//bazel:swift_static_framework.bzl", "swift_static_framework")

swift_static_framework(
    name = "ios_interfaces_framework",
    srcs = [
        "Client.swift",
        "EnvoyError.swift",
        "LogLevel.swift",
        "RequestMethod.swift",
        "RetryPolicy.swift",
        "StreamEmitter.swift",
    ],
    module_name = "EnvoyInterfaces",
    visibility = ["//visibility:public"],
)

swift_static_framework(
    name = "ios_framework",
    srcs = [
        "Envoy.swift",
        "EnvoyBuilder.swift",
        "EnvoyStreamEmitter.swift",
        "Request.swift",
        "RequestBuilder.swift",
        "RequestMapper.swift",
        "ResponseHandler.swift",
        "RetryPolicyMapper.swift",
    ],
    module_name = "Envoy",
    objc_includes = [
        "//library/objective-c:EnvoyEngine.h",
    ],
    visibility = ["//visibility:public"],
    deps = [
        ":ios_interfaces_framework",
        "//library/objective-c:envoy_engine_objc_lib",
    ],
)
