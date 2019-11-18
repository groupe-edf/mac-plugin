# Mac Plugin

This plugin allows to configure a cloud of Mac in Jenkins configuration.

Like docker and kubernetes plugins does, you can configure your builds to run on a cloud of Mac.

All builds are independent and there is a restricted space dedicated to read and write to this single build. This space is removed at the end of the build so that no traces remain on the machine.

## Features

- [x] Allow to configure a Mac as Jenkins slave
- [x] Run multiples builds on a single Mac
- [x] Run builds on a cloud of Mac
- [x] Clean all files created after each build
- [] Support Cocoapod repository (in progress)

This plugin has been tested against macOS 10.14 Mojave and macOS 10.15 Catalina , although theoretically it should work with older version as long as it supports sysadminctl command.

## Requirement

- A jdk must be installed on a Mac.
- A user with administrator rights and sudo nopasswd configured : [see how to configure sudo without password](https://www.robertshell.com/blog/2016/12/3/use-sudo-command-osx-without-password)

## Plugin configuration
In jenkins global configuration, add a new Mac Cloud :

<img src="https://image.noelshack.com/fichiers/2019/32/4/1565272720-addmaccloud.png" width="200"/>

Configure fields of Mac Cloud :

<img src="https://image.noelshack.com/fichiers/2019/42/1/1571074130-cloud-config.png" width="750"/>

Select JNLP for the connector and refer your Jenkins URL. This URL must be accessible by outside, localhost is not working.

Add a new Mac Host and fill the properties in the fields :

<img src="https://image.noelshack.com/fichiers/2019/42/1/1571074130-host-config.png" width="750"/>

The number of simultaneous builds on the same Mac Host depends of the property "Max users".
More you have Mac Hosts configured, more you can build simultaneous on many machines.
**For best usage I recommend a limit of 3.**

The supported credentials for now is User and Password.
Put an account of your mac with **sudo NOPASSWORD configured**.

After it refers the label of your agent.
Select JNLP for the connector and refer your Jenkins URL. This URL must be accessible by outside, localhost is not working.

In a project configuration, refers the label :

<img src="https://image.noelshack.com/fichiers/2019/42/1/1571074794-job-label-config.png" width="750"/>

## Logs configuration
You can define a custom LOGGER to log every output of the plugin on the same place.
To do it, go to System logs in the Jenkins configuration :

<img src="https://image.noelshack.com/fichiers/2019/32/4/1565272759-logs-system.png" width="400"/>

Configure the Logger of the plugin :
<img src="https://image.noelshack.com/fichiers/2019/42/1/1571074130-custom-log-config.png" width="750"/>

Save your configuration.

## Execution
After configuration, when you run a job with a Mac Cloud label, it will create a jenkins agent on the mac you setted as host and run the build on it.

You can see it on the home page of Jenkins :

<img src="https://image.noelshack.com/fichiers/2019/42/1/1571074130-build-capture.png" width="300"/>


