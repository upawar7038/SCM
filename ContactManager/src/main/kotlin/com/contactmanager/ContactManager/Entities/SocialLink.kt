package com.contactmanager.ContactManager.Entities

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class SocialLink(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var socialId:Int,
    var link:String,
    var title:String,
    @ManyToOne
    var contactId:Contact

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SocialLink

        return socialId != null && socialId == other.socialId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(socialId = $socialId , link = $link , title = $title )"
    }
}
