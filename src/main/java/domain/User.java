package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.AVG;

@javax.persistence.Entity
public class User {

    @Id
    private String token;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Double averageRank;
    private Integer numOfRankers;
    private String image;
    private Role role;
    @ElementCollection private List<String> wishList;
    

    public User(){}

    public User(String token, String firstName, String lastName, String gender, String email, String image,Role role) {
        this.setImage(image);
        this.setToken(token);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        averageRank = 0.0;
        numOfRankers = 0;
        wishList = new ArrayList<>();
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Double getAvgRankLandLoard() {
//        return avgRankLandLoard.getSecond();
//    }
//
//    public void setAvgRankLandLoard(Double rank) {
//    	Rank.rank(avgRankLandLoard, rank);
//    }

    public Double getAvgRankRanker() {
        return averageRank;
    }

    public void setAvgRankRanker(double rank) {
    	numOfRankers++;
    	averageRank = (numOfRankers * averageRank + averageRank) / numOfRankers;    
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void addApartmentToWishList(String address) {
    	wishList.add(address);
    }

	public List<String> getWishList() {
		return wishList;
	}
	
	public Role getRole() {
		return role;
	}

	public boolean isRoot() {
		return role == Role.Root;
	}
	
	
}

