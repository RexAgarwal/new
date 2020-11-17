from django.urls import path

from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("login", views.login_view, name="login"),
    path("logout", views.logout_view, name="logout"),
    path("register", views.register, name="register"),
    path("create",views.create_list,name="create_listing"),
    path("listings/<int:id_no>",views.show_list,name="show_list"),
    path("watchlist",views.watchlist,name="Watchlist"),
    path("category",views.category,name="category"),
    path("category/<str:name>",views.category_item,name="category_item"),
   

]
