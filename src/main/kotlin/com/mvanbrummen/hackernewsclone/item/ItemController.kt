package com.mvanbrummen.hackernewsclone.item

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/items")
class ItemController {

    @GetMapping
    fun getItems(): ResponseEntity<String> {
        return ResponseEntity.ok("should be protected")
    }
}