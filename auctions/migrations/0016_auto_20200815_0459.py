# Generated by Django 3.0.8 on 2020-08-15 04:59

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('auctions', '0015_auto_20200815_0438'),
    ]

    operations = [
        migrations.AlterField(
            model_name='auction_listing',
            name='category',
            field=models.CharField(blank=True, choices=[['magical item', 'magical item'], ['Toys', 'Toys'], ['Clothing', 'Clothing'], ['Potion', 'Potion'], ['Books', 'Books']], max_length=64),
        ),
    ]
