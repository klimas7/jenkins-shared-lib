#!/usr/bin/env groovy
import pl.klimas7.jenkins.Rectangle

def call(body) {
    echo "Disable throttling"

    script:this.echo(new Rectangle(1, 3).toString())

    return this
}