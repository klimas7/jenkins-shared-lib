# Jenkins Shared Library Sample

Setup

1. Manage Jenkins → Configure System. Under Global Pipeline Libraries, add a library with the following settings:
  * Library name: jenkins-shared-lib
  * Default version: master
  * Retrieval method: Modern SCM
  * Select the Git type
  * Project repository: https://github.com/klimas7/jenkins-shared-lib.git
  * Credentials: (leave blank)


2. Then create a Jenkins job with the following pipeline (note that the underscore _ is not a typo):

```
@Library('jenkins-shared-lib')_

stage('Print Build Info') {
    printBuildinfo {
        name = "Sample Name"
    }
} stage('Disable throttling') {
    disableThrottling()
} stage('Deploy') {
    deploy()
} stage('Enable throtling') {
    enableThrottling()
} stage('Check Status') {
    checkStatus()
}
```


Run job!

```
@Library('jenkins-shared-lib')_

pipeline {
    parameters {
        string defaultValue: 'One default', description: '', name: 'param1', trim: false
        string defaultValue: 'Two default', description: '', name: 'param2', trim: false
    }
    agent any
    
    stages {
        stage('Print Build Info') {
            steps {
                script {
                    printBuildinfo {
                        name = "Sample Name"
                    }
                }
            }
        }
        stage('Disable throttling') {
            steps {
                script {
                    disableThrottling()
                }
            }
        }
        stage('Deploy') {
            steps {
                script { 
                    deploy()
                }
            }
        }
        stage('Enable throtling') {
            steps {
                script {
                    enableThrottling()
                }
            }
        }
        stage('Check Status') {
            steps {
                script {
                    checkStatus()
                }
            }
        }
    }
}
```