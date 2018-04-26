import Vue from 'vue';
import { APIENDPOINT , getHeader } from '../../app.config';
import axios from 'axios';
export default {

  getUserInfo(nickName) {
    return new Promise(function (resolve, reject) {
      axios.get(APIENDPOINT + '/users/'+nickName)
        .then(function (res) {
          resolve(res);
        })
        .catch(function (err) {
          reject("get User info error")
        })
    });

  },

  getKeks(nickName) {
    return new Promise(function (resolve, reject) {
      axios.get(APIENDPOINT + '/users/'+nickName+"/keks")
        .then(function (res) {
          resolve(res);
        })
        .catch(function (err) {
          reject("get keks error")
        })
    });

  },
  getCommentsOfKek(dbComments){
    var comments =[];
    if(dbComments != null){
    dbComments.forEach(function (el) {
       comments.push({
         owner_id : el.owner.nickName,
         owner_avatar: el.owner.avatarUrl,
         owner_nickname: el.owner.nickName,
         text: el.text,
         date: el.creationDate
       });
    });
    }
    return comments;
  },
  getReactionsOfKek(dbReactions){
    var reactions =[];
    if(dbReactions != null){
      dbReactions.forEach(function (el) {
        reactions.push({
          type: el.type,
          owner_avatar: el.owner.avatarUrl,
          owner_nickname: el.owner.nickName,
        });
      });
    }
    return reactions;
  }

}
