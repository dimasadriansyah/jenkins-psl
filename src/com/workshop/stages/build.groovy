#!/usr/bin/groovy
package com.workshop.stages
import com.workshop.Pipeline
import com.workshop.Config
def build(Pipeline p) {
 c = new Config()
 docker.withTool("${c.default_docker_jenkins_tool}") {
 docker.withRegistry("${p.docker_registry}",
"${c.default_docker_registry_jenkins_cred}") {
 def image =
docker.build("${p.docker_user}/${p.repository_name}:build-$BUILD_NUMBER")
 image.push()
 image.push('latest')
 }
 }
}
