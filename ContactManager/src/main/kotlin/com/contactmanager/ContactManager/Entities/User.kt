package com.contactmanager.ContactManager.Entities

import com.contactmanager.ContactManager.Utils.Providers
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity(name = "user")
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int,
    @Column(name = "UserName")
    val name: String,
    @Column(name = "EmailId")
    val email: String,
    @Column(name = "Password")
    val password: String,
    @Column(name = "About")
    val about: String,
    @Column(name = "ProfilePic")
    val profilePic: String,
    @Column(name = "MobileNo")
    val mobileNo: String,
    val isEnable: Boolean = false,
    val provider: Providers=Providers.SELF,
    val providerID:String,
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, orphanRemoval = true)
    var contact: ArrayList<Contact>,


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return userId != null && userId == other.userId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(userId = $userId , name = $name , email = $email , password = $password , about = $about , profilePic = $profilePic , mobileNo = $mobileNo , isEnable = $isEnable , provider = $provider , providerID = $providerID )"
    }
}
