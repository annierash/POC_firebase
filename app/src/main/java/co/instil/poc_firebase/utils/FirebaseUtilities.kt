package co.instil.poc_firebase.utils

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import co.instil.poc_firebase.utils.Constants.URI_PREFIX
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase



fun buildDeepLink(deepLink: Uri): Uri {
    val uriPrefix = URI_PREFIX

    val deepLink = Firebase.dynamicLinks.dynamicLink {
        domainUriPrefix = uriPrefix
        androidParameters {
            build()
        }
        socialMetaTagParameters {
            title = "Dynamic Link Example"
            imageUrl = "https://www.mantralabsglobal.com/wp-content/uploads/2017/05/Android_thumb800.jpg".toUri()
            description = "Android Phones RULE!"
        }
        link = deepLink
    }

    return deepLink.uri
}


fun buildShortLink(deepLink: Uri, minVersion: Int, getShareableLink: (String) -> Unit) {
    val uriPrefix = URI_PREFIX
    Firebase.dynamicLinks.shortLinkAsync {
        domainUriPrefix = uriPrefix
        link = Uri.parse(deepLink.toString())
        androidParameters {
            minimumVersion = minVersion
        }
        socialMetaTagParameters {
            title = "Example of a Dynamic Link"
            description = "This link works whether the app is installed or not!"
        }
    }.addOnSuccessListener { dynamicLink ->
        getShareableLink(dynamicLink.shortLink.toString())
    }
        .addOnFailureListener{ e ->
            Log.d(TAG, "generateSharingLink: Failure", e)
        }
}



fun Context.shareDeepLink(deepLink: String) {
    val share = Intent.createChooser(Intent().apply {
    action = Intent.ACTION_SEND
    type = "text/plain"
    putExtra(Intent.EXTRA_SUBJECT, "Firebase Deep Link")
    putExtra(Intent.EXTRA_TEXT, deepLink)
    }, null)
    startActivity(share)
}

