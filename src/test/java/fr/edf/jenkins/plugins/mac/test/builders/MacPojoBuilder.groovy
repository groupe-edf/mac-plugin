package fr.edf.jenkins.plugins.mac.test.builders

import org.jvnet.hudson.test.JenkinsRule

import fr.edf.jenkins.plugins.mac.MacHost
import fr.edf.jenkins.plugins.mac.MacUser
import fr.edf.jenkins.plugins.mac.connector.MacComputerConnector
import fr.edf.jenkins.plugins.mac.connector.MacComputerJNLPConnector
import hudson.util.Secret

class MacPojoBuilder {
    
    static List<MacHost> buildMacHost() {
        MacHost host = new MacHost(
                'localhost', //host
                '1', //credentialsId
                0, //port
                10, //maxUsers
                5, //connectionTimeout
                5, //readTimeout
                5,//kexTimeout
                false, //disabled
                5, //maxTries
                "testLabel" //label
                )
        List<MacHost> hostList = new ArrayList()
        hostList.add(host)
        return hostList
    }

    static MacComputerConnector buildConnector(JenkinsRule jenkinsRule) {
        return new MacComputerJNLPConnector(jenkinsRule.getURL().toString())
    }
    
    static MacUser buildUser() {
        return new MacUser("toto", Secret.fromString("root"), "/Users/toto")
    }
}
