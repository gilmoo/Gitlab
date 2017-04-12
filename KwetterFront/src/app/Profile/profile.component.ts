import { Component, OnInit, ViewChild } from '@angular/core'

import { UserService } from './../rest/user.service';
import { TweetService } from './../rest/tweet.service';
import { User } from './../domain/User';
import { Tweet } from './../domain/Tweet';
import { Role } from './../domain/Role';

@Component({
    selector: 'profile-page',
    templateUrl: './profile.html',
    styleUrls: ['./../app.component.css']
})

export class ProfilePageComponent implements OnInit {
    private loggedUser: string = 'ruthger_vde';
    private username: string;
    private password: string;
    private friends: User[];
    private users_friends: User[];
    private roles: Role[];
    private name: string;
    private bio: string;
    private web: string;
    private location: string;
    private image: string;

    user: User;
    allTweets: Tweet[];
    tweet: Tweet;
    datum: string;
    tbTweetValue: string = "";
    countFollowing: number = 0;
    countFollowers: number = 0;
    countTweets: number = 0;

    constructor(private userService: UserService, private tweetService: TweetService) { }

    ngOnInit(): void {
        this.onClickGetUser();
    }

    onclickCreateTweet(tweet: string) {
        this.tbTweetValue = ""; 
        this.datum = Date.toString();
        this.tweet = new Tweet(tweet,this.datum,this.loggedUser);
        this.tweetService.createNewTweet(this.tweet)
                         .then(value => this.allTweets.push(value))
                         .then(() => this.countTweets = this.allTweets.length);
        console.log(this.tbTweetValue);  
    }

    onClickGetUser(): void {
        this.userService.getUserByUsername(this.loggedUser)
            .then(value => this.user = value)
            .then(() => this.username = this.user.username)
            .then(() => this.password = this.user.password)
            .then(() => this.bio = this.user.bio)
            .then(() => this.friends = this.user.friends)
            .then(() => this.location = this.user.location)
            .then(() => this.image = this.user.image)
            .then(() => this.name = this.user.name)
            .then(() => this.roles = this.user.roles)
            .then(() => this.users_friends = this.user.users_friends)
            .then(() => this.web = this.user.web)
            .then(() => this.countFollowing = this.user.friends.length)
            .then(() => this.countFollowers = this.user.users_friends.length)
            .then(() => console.log(this.user));

        this.tweetService.getTweetsByUsername(this.loggedUser)
            .then(value => this.allTweets = value)
            .then(() => this.countTweets = this.allTweets.length)
            .then(() => console.log(this.allTweets));
    }
}