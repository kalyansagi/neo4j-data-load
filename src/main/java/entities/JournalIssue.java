package main.java.entities;

public class JournalIssue {
 private String Volume;
 private String Issue;
 PubDate PubDateObject;
 private String _CitedMedium;


 // Getter Methods

 public String getVolume() {
  return Volume;
 }

 public String getIssue() {
  return Issue;
 }

 public PubDate getPubDate() {
  return PubDateObject;
 }

 public String get_CitedMedium() {
  return _CitedMedium;
 }

 // Setter Methods

 public void setVolume(String Volume) {
  this.Volume = Volume;
 }

 public void setIssue(String Issue) {
  this.Issue = Issue;
 }

 public void setPubDate(PubDate PubDateObject) {
  this.PubDateObject = PubDateObject;
 }

 public void set_CitedMedium(String _CitedMedium) {
  this._CitedMedium = _CitedMedium;
 }
}
