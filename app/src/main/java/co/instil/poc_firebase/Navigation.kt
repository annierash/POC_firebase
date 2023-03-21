package co.instil.poc_firebase

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItem("home", R.drawable.ic_baseline_home_24, "Home")
    object Account: NavigationItem("account", R.drawable.ic_baseline_account_box_24,"Account")
    object Shop: NavigationItem("shop", R.drawable.ic_baseline_shopping_bag_24, "Shop")
    object Billing: NavigationItem("billing", R.drawable.ic_baseline_payment_24,"Billing")
    object Help: NavigationItem("help", R.drawable.ic_baseline_help_24, "Help")
}
