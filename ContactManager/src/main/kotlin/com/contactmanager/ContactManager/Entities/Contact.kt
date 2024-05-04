package com.contactmanager.ContactManager.Entities

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var email: String,
    var mobileNo: String,
    var address: String,
    var picture: String,
    var description: String,
    var favorite: Boolean = false,
    var webSiteLink: String,
    @ManyToOne
    var user:User,
    @OneToMany(mappedBy = "contactId", cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, orphanRemoval = true)
    var links:ArrayList<SocialLink>

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Contact

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , email = $email , mobileNo = $mobileNo , address = $address , picture = $picture , description = $description , favorite = $favorite , webSiteLink = $webSiteLink , user = $user )"
    }
}
