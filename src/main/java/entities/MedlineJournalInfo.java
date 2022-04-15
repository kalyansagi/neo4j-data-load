package main.java.entities;

public class MedlineJournalInfo {
 private String Country;
 private String MedlineTA;
 private String NlmUniqueID;
 private String ISSNLinking;


 // Getter Methods

 public String getCountry() {
  return Country;
 }

 public String getMedlineTA() {
  return MedlineTA;
 }

 public String getNlmUniqueID() {
  return NlmUniqueID;
 }

 public String getISSNLinking() {
  return ISSNLinking;
 }

 // Setter Methods

 public void setCountry(String Country) {
  this.Country = Country;
 }

 public void setMedlineTA(String MedlineTA) {
  this.MedlineTA = MedlineTA;
 }

 public void setNlmUniqueID(String NlmUniqueID) {
  this.NlmUniqueID = NlmUniqueID;
 }

 public void setISSNLinking(String ISSNLinking) {
  this.ISSNLinking = ISSNLinking;
 }
}
