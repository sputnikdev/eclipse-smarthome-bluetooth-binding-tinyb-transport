#!/usr/bin/env bash
if [ "$TRAVIS_PULL_REQUEST" == 'false' ] && [ ! -z "$TRAVIS_TAG" ]
then
    openssl aes-256-cbc -K $encrypted_a44e45e73514_key -iv $encrypted_a44e45e73514_iv -in .travis/codesigning.asc.enc -out .travis/codesigning.asc -d
    gpg --fast-import .travis/codesigning.asc
fi