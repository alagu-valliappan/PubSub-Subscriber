/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pubsub.subscriber;

import pubsub.subscriber.broker.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pubsub.message.NetworkMessage;
import pubsub.subscriber.ui.SubscriberUI;
import pubsub.subscriber.utils.Constants;

/**
 *
 * @author AL
 */
public class PubSubSubscriber {

    private String brokerAddress;
    public static Client broker;
    public boolean isBrokerAvailable = false;
    
    public PubSubSubscriber(String address){
        this.brokerAddress = address;
        this.broker = new Client(brokerAddress, Constants.BROKER_PORT);
        
        /*try {
            SubscriberUI.hostAddrIP = InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PubSubSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    /*public boolean registerViaEmail(String email){
        //set message type "ADD_SUBSCRIBER" + set email = this.email in message
            NetworkMessage.Messages.Builder message = NetworkMessage.Messages.newBuilder();
            message.setMessageType(NetworkMessage.Messages.MessageType.ADD_SUBSCRIBER);
            
            NetworkMessage.Messages.Subscriber.Builder subscriberMsg = NetworkMessage.Messages.Subscriber.newBuilder();
            subscriberMsg.setEmail(email);
            message.setSubscriber(subscriberMsg);
            
            return broker.send(message.build());

    }
    public boolean registerViaIP(String IP){
        //set message type "ADD_SUBSCRIBER" + set email = this.email in message
        NetworkMessage.Messages.Builder message = NetworkMessage.Messages.newBuilder();
        message.setMessageType(NetworkMessage.Messages.MessageType.ADD_SUBSCRIBER);
            
        NetworkMessage.Messages.Subscriber.Builder subscriberMsg = NetworkMessage.Messages.Subscriber.newBuilder();
        subscriberMsg.setHostAddress(IP);
        message.setSubscriber(subscriberMsg);
            
        return broker.send(message.build());
    }*/

    public void refresh(String regMode, String host) {
        NetworkMessage.Messages.Builder message = NetworkMessage.Messages.newBuilder();
        message.setMessageType(NetworkMessage.Messages.MessageType.GET_TOPICS);
        broker.send(message.build());
        
        NetworkMessage.Messages.Builder message1 = NetworkMessage.Messages.newBuilder();
        message1.setMessageType(NetworkMessage.Messages.MessageType.GET_SUBSCRIBEDTOPICS);
        
        NetworkMessage.Messages.Subscriber.Builder sub = NetworkMessage.Messages.Subscriber.newBuilder();
        if(regMode.equals("ip")){
            sub.setHostAddress(host);
        }
        else if(regMode.equals("email")){
            sub.setEmail(host);
        }
        message1.setSubscriber(sub);
        
        broker.send(message1.build());
        
        SubscriberUI.refresh = true;
    }

    public void subscribe(String topic, String regMode, String host) {
        NetworkMessage.Messages.Builder message = NetworkMessage.Messages.newBuilder();
        message.setMessageType(NetworkMessage.Messages.MessageType.ADD_SUBSCRIBER);
        //check what index is?
        message.addTopics(topic);
        
        NetworkMessage.Messages.Subscriber.Builder sub = NetworkMessage.Messages.Subscriber.newBuilder();
        if(regMode.equals("ip")){
            sub.setHostAddress(host);
        }
        else if(regMode.equals("email")){
            sub.setEmail(host);
        }
        message.setSubscriber(sub);
        broker.send(message.build());
        
        
    }

    public void unSubscribe(String topic, String regMode, String host) {
        NetworkMessage.Messages.Builder message = NetworkMessage.Messages.newBuilder();
        message.setMessageType(NetworkMessage.Messages.MessageType.REMOVE_SUBSCRIBER);
        //check what index is?
        message.addTopics(topic);
        
        NetworkMessage.Messages.Subscriber.Builder sub = NetworkMessage.Messages.Subscriber.newBuilder();
        if(regMode.equals("ip")){
            sub.setHostAddress(host);
        }
        else if(regMode.equals("email")){
            sub.setEmail(host);
        }
        message.setSubscriber(sub);
        broker.send(message.build());
    }
}
