from django.contrib import admin
from .models import *

# Register your models here.
admin.site.register(Auction_listing)
admin.site.register(Bids)
admin.site.register(Watchlist)
admin.site.register(Comments)