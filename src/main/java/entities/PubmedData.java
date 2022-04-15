package main.java.entities;

import main.java.entities.ArticleIdList;
import main.java.entities.History;

public class PubmedData {
 History HistoryObject;
 private String PublicationStatus;
 ArticleIdList ArticleIdListObject;


 // Getter Methods

 public History getHistory() {
  return HistoryObject;
 }

 public String getPublicationStatus() {
  return PublicationStatus;
 }

 public ArticleIdList getArticleIdList() {
  return ArticleIdListObject;
 }

 // Setter Methods

 public void setHistory(History HistoryObject) {
  this.HistoryObject = HistoryObject;
 }

 public void setPublicationStatus(String PublicationStatus) {
  this.PublicationStatus = PublicationStatus;
 }

 public void setArticleIdList(ArticleIdList ArticleIdListObject) {
  this.ArticleIdListObject = ArticleIdListObject;
 }
}
