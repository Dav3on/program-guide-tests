package com.megogo.enums

enum MegogoResponseStatus {

    OK("ok"),
    ERROR("error")

    String status

    MegogoResponseStatus(String status) {
        this.status = status
    }
}