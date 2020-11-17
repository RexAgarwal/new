from django.contrib.auth.models import AbstractUser
from django.db import models


class User(AbstractUser):
    pass



class Auction_listing(models.Model):
    CATEGORY = [
    ['magical item', 'magical item'],
    ['Toys', 'Toys'],
    ['Clothing', 'Clothing'],
    ['Potion', 'Potion'],
    ['Books', 'Books']
]
    title = models.CharField(max_length=64)
    description = models.CharField(max_length=500)
    image_url = models.ImageField(max_length=1024,blank = True, default = "https://thumbs.dreamstime.com/b/no-image-available-icon-flat-vector-no-image-available-icon-flat-vector-illustration-132482930.jpg")
    category = models.CharField(max_length=64,blank = True,choices = CATEGORY)
    user = models.ForeignKey(User, blank=True,on_delete = models.CASCADE)
    starting_price = models.IntegerField()
    is_active = models.BooleanField(default = True)

    def __str__(self):
        return f"{self.title}"
    



class Bids(models.Model):
    auction_listing = models.ForeignKey(Auction_listing, blank=True,null=True,on_delete = models.CASCADE,related_name="auction_listing")
    amount = models.IntegerField(blank=True, null=True)
    user = models.ForeignKey(User, blank=True,null=True,on_delete = models.CASCADE)

    def __str__(self):
        return f"{self.amount}"

class Watchlist(models.Model):
    currentUser = models.ForeignKey(User,blank=True,on_delete=models.CASCADE, related_name = "currentUser")
    item = models.ForeignKey(Auction_listing,blank=True,on_delete=models.CASCADE, related_name="item")
    

    def __str__(self):
        return f"{self.item.title} by {self.currentUser.username}"
    

    


class Comments(models.Model):
    text = models.CharField(max_length=1024,null=True,blank=True)
    user = models.ForeignKey(User,blank=True,null=True,on_delete=models.CASCADE, related_name = "user")
    auction = models.ForeignKey(Auction_listing,blank=True,null=True,on_delete=models.CASCADE, related_name="auction")

    def __str__(self):
        return f"{self.text}"



        
