import { Component, OnInit, ViewChild } from '@angular/core'

import { UserService } from './../rest/user.service';
import { TweetService } from './../rest/tweet.service';
import { User } from './../domain/User';
import { Tweet } from './../domain/Tweet';
import { Role } from './../domain/Role';

@Component({
    selector: 'timeline-page',
    templateUrl: './timeline.html',
    styleUrls: ['./../app.component.css']
})

export class TimelinePageComponent implements OnInit {
    private tbTweetValue: string;
    private datum: string;
    private tbSearchValue: string;

    private loggedUser: string = "ruthger_vde";
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

    private tweet: Tweet;
    private user: User;
    private allTweets: Tweet[];
    private countTweets: number;
    constructor(private userService: UserService, private tweetService: TweetService) { }
    ngOnInit(): void {
        this.onLoadMethod();
    }

    onLoadMethod(): void {
        this.tweetService.getAllTweets()
            .then(value => this.allTweets = value)
            .then(() => this.countTweets = this.allTweets.length)
            .then(() => console.log(this.allTweets));
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
            .then(() => this.web = this.user.web);
    }

    onclickCreateTweet(tweet: string) {
        this.tbTweetValue = "";
        this.datum = Date.toString();
        this.tweet = new Tweet(tweet, this.datum, this.loggedUser);
        this.tweetService.createNewTweet(this.tweet)
            .then(value => this.allTweets.push(value))
            .then(() => this.countTweets = this.allTweets.length);
        console.log(this.tbTweetValue);
    }

    onClickSearchTweet(tweet: string) {
        this.tbSearchValue = "";
        if (tweet == "") {
            this.onLoadMethod();
        } else {
            this.tweetService.getSearchTweet(tweet, tweet)
                .then(value => this.allTweets = value)
                .then(() => this.countTweets = this.allTweets.length)
                .then(() => console.log(this.allTweets));
        }
    }

}