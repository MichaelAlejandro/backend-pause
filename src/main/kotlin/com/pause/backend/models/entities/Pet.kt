package com.pause.backend.models.entities

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "pets")
data class Pet(
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    val user: User,

    @Column(nullable = false)
    var petName: String,

    @Column(nullable = false)
    var state: String,

    @ElementCollection
    @CollectionTable(name = "unlocked_items", joinColumns = [JoinColumn(name = "pet_id")])
    @Column(name = "item")
    var unlockedItems: Set<String> = emptySet(),

    @Column
    var customization: String? = null
) : BaseEntity()