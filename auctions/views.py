from django.contrib.auth import authenticate, login, logout
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse

from .models import *


    



def index(request):
    if request.method == "POST":
        Auction_listing.objects.filter(id = request.POST["id"]).update(is_active = False)
        print( Auction_listing.objects.get(id = request.POST["id"]).is_active)
    return render(request, "auctions/index.html",{"auctions": Auction_listing.objects.all(),"bids" : Bids.objects.all()})


def login_view(request):
    if request.method == "POST":

        # Attempt to sign user in
        username = request.POST["username"]
        password = request.POST["password"]
        user = authenticate(request, username=username, password=password)

        # Check if authentication successful
        if user is not None:
            login(request, user)
            return HttpResponseRedirect(reverse("index"))
        else:
            return render(request, "auctions/login.html", {
                "message": "Invalid username and/or password."
            })
    else:
        return render(request, "auctions/login.html")


def logout_view(request):
    logout(request)
    return HttpResponseRedirect(reverse("index"))


def register(request):
    if request.method == "POST":
        username = request.POST["username"]
        email = request.POST["email"]

        # Ensure password matches confirmation
        password = request.POST["password"]
        confirmation = request.POST["confirmation"]
        if password != confirmation:
            return render(request, "auctions/register.html", {
                "message": "Passwords must match."
            })

        # Attempt to create new user
        try:
            user = User.objects.create_user(username, email, password)
            user.save()
        except IntegrityError:
            return render(request, "auctions/register.html", {
                "message": "Username already taken."
            })
        login(request, user)
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "auctions/register.html")

def create_list(request):
    if request.method == "POST":
        title = request.POST["Title"]
        description = request.POST["Description"]
        image_url = request.POST["Image_url"]
        category = request.POST["Category"]
        price = request.POST["Price"]
        obj = Auction_listing(title = title, description=description,image_url =  image_url,category =  category, starting_price = price)
        obj.user_id = request.user.id
        obj.save()
        Bids.objects.create(amount=price,user_id = request.user.id,auction_listing_id = obj.id)
    k = Auction_listing.objects.get(id=1).CATEGORY
    categories = []
    for item in k:
        categories.append(item[0])  

    return render(request, "auctions/create_list.html",{"auctions": Auction_listing.objects.all(),"categories":categories})

def show_list(request,id_no):
    in_watchlist = False
    auction = Auction_listing.objects.get(id = id_no)
    bid = Bids.objects.get(auction_listing_id = id_no)
    comments = Comments.objects.filter(auction_id = id_no)
    auction_madeby = User.objects.get(id = auction.user_id)
    max_bidby = User.objects.get(id = bid.user_id)
    close_allowed = auction_madeby.username == request.user.username
    if request.user.is_authenticated:
        for watchlist in Watchlist.objects.filter(currentUser=request.user):
            if watchlist.item_id == id_no:
                in_watchlist = True
            
        

    

    if request.method == "POST":
        if request.POST.get("text"):
            Comments.objects.create(text=request.POST["text"],user_id = request.user.id,auction_id = id_no)
            return render(request, "auctions/item.html",{"auction":auction,"bid":bid, "Auction_madeby":auction_madeby,"in_watchlist":in_watchlist,"Max_bidby":max_bidby,"close":close_allowed,"comments":comments})
        if request.user.is_authenticated:
            new_bid = request.POST["bid"]
            Bids.objects.filter(auction_listing_id = id_no).update(amount = new_bid,user_id = request.user.id)
            bid = Bids.objects.get(auction_listing_id = id_no)
        else :
            return render(request, "auctions/register.html", {
                "message": "You need to login to place bids."
            })

    
         
        
    
    

    
    return render(request, "auctions/item.html",{"auction":auction,"bid":bid, "Auction_madeby":auction_madeby,"Max_bidby":max_bidby,"close":close_allowed,"in_watchlist":in_watchlist,"comments":comments})

def watchlist(request):
    list = Watchlist.objects.filter(currentUser=request.user)
    
    if request.method == "POST":
        id = request.POST["id"]
        if request.POST.get("remove") == "remove":
            b = Watchlist.objects.get(item_id = id,currentUser = request.user)
            b.delete()
        else :
            auction = Auction_listing.objects.get(id =id)
            Watchlist.objects.create(currentUser = request.user,item = auction)
            



        
        
        list = Watchlist.objects.filter(currentUser=request.user)
        
    

        
    
    

    

    return render(request,"auctions/watchlist.html",{"watchlists":list})



def category(request):
    k = Auction_listing.objects.get(id=1).CATEGORY
    categories = []
    for item in k:
        categories.append(item[0])

    return render(request,"auctions/category.html",{"categories":categories})


def category_item(request,name):
    auctions = Auction_listing.objects.filter(category=name)
    return render(request,"auctions/category_item.html",{"auctions":auctions,"category":name})






    



     
    

    


    


