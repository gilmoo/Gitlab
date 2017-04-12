package domain;

import domain.Role;
import domain.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-12T14:02:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> user_id;
    public static volatile SingularAttribute<User, String> web;
    public static volatile ListAttribute<User, Role> roles;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, User> users_friend;
    public static volatile SingularAttribute<User, String> bio;
    public static volatile SingularAttribute<User, String> location;
    public static volatile ListAttribute<User, User> friends;
    public static volatile SingularAttribute<User, String> username;

}