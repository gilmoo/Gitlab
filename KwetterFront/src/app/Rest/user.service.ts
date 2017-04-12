import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { User } from './../Domain/User';

@Injectable()
export class UserService {
    private url = "http://localhost:8080/Kwetter/api/User/";

    constructor(private http: Http) { }
    
    getUserByUsername(username: string): Promise<User> {
        return this.http.get(this.url + "userByUsername/" + username)
            .toPromise()
            .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
    
}