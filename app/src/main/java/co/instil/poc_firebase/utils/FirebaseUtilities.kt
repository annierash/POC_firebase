package co.instil.poc_firebase.utils

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase


fun generateShortSharingLink(
    deepLink: Uri,
    getShareableLink: (String) -> Unit = {}
) {
    FirebaseDynamicLinks.getInstance().createDynamicLink().run {
        link = deepLink
        domainUriPrefix = "https://POCfirebase1821.page.link"

        androidParameters {
            build()
        }

        buildShortDynamicLink()
    }.also {
        it.addOnSuccessListener { dynamicLink ->
            getShareableLink.invoke(dynamicLink.shortLink.toString())
        }
        it.addOnFailureListener { exception ->
            Log.d(TAG, "generateSharingLink: ${exception.message}")
        }
    }
}

fun buildDeepLink(deepLink: Uri): Uri {
    val uriPrefix = "https://POCfirebase1821.page.link"

    val link = Firebase.dynamicLinks.dynamicLink {
        domainUriPrefix = uriPrefix
        androidParameters {
            build()
        }
        link = deepLink
    }

    return link.uri
}

fun shortenLongLink(deepLink: Uri, minSDK: Int) {
    val uriPrefix = "https://POCfirebase1821.page.link"

    Firebase.dynamicLinks.shortLinkAsync {
        link = deepLink
        domainUriPrefix = uriPrefix
        androidParameters {
            minimumVersion = minSDK
        }
        socialMetaTagParameters {
            title = "Example of a Dynamic Link"
            description = "This link works whether the app is installed or not!"
        }
    }.addOnSuccessListener { dynamicLink ->
        dynamicLink.shortLink.toString()


    }.addOnFailureListener() { e ->
        Log.e(TAG, e.toString());
    }
}


fun Context.shareDeepLink(deepLink: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_SUBJECT, "Firebase Deep Link")
    intent.putExtra(Intent.EXTRA_TEXT, deepLink)
    startActivity(intent)
}

