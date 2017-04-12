import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Tweet } from './../Domain/Tweet';

@Injectable()
export class TweetService {
    private url = "http://localhost:8080/Kwetter/api/Tweet/";

    constructor(private http: Http) { }

    getTweetsByUsername(username: string): Promise<Tweet[]> {
        return this.http.get(this.url + "tweetsByUser/" + username)
            .toPromise()
            .then(this.extractData);
    }

    getAllTweets(): Promise<Tweet[]>{
        return this.http.get(this.url + "allTweets")
            .toPromise()
            .then(this.extractData);
    }

    getSearchTweet(bericht:string, username:string): Promise<Tweet[]>{
        return this.http.get(this.url + "tweetSearch/"+bericht+"/"+username)
            .toPromise()
            .then(this.extractData);
    }

    createNewTweet(tweet : Tweet) : Promise<Tweet> {
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + 'createTweet/', JSON.stringify(tweet), {headers: header})
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
    
}