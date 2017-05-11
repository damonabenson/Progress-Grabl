package io.gitlab.hendosdo.grabl

import groovy.json.JsonSlurper
import groovy.json.JsonException


class BuildUtil {
    static Map<String, List<String>> loadDbDeps(String dbDepFile = 'build/grablDbDepCache.json') {
        def dbDeps = [:]
        def js = new JsonSlurper()
        try {
            dbDeps = js.parse(new File(dbDepFile))
        } catch(JsonException e) {
            // TODO: replace with logger? (see https://docs.gradle.org/current/userguide/logging.html)
            println "WARN: couldn't parse DB dependencies file ${dbDepFile}, error: ${e}"
        }
        return dbDeps
    }
}
