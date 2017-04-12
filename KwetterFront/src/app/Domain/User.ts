import { Role } from "app/domain/Role";
export class User {
    constructor(
        public id: number,
        public username: string,
        public password: string,
        public friends: User[],
        public users_friends: User[],
        public roles: Role[],
        public name: string,
        public bio: string,
        public web: string,
        public location: string,
        public image: string
    ) {

    }
}