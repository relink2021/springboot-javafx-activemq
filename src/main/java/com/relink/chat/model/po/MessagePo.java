package com.relink.chat.model.po;

import java.time.LocalDateTime;

public class MessagePo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message_id
     *
     * @mbg.generated
     */
    private Integer messageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.sender
     *
     * @mbg.generated
     */
    private Integer sender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.receiver
     *
     * @mbg.generated
     */
    private Integer receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.timestamp
     *
     * @mbg.generated
     */
    private LocalDateTime timestamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message_id
     *
     * @return the value of message.message_id
     *
     * @mbg.generated
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message_id
     *
     * @param messageId the value for message.message_id
     *
     * @mbg.generated
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.sender
     *
     * @return the value of message.sender
     *
     * @mbg.generated
     */
    public Integer getSender() {
        return sender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.sender
     *
     * @param sender the value for message.sender
     *
     * @mbg.generated
     */
    public void setSender(Integer sender) {
        this.sender = sender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.receiver
     *
     * @return the value of message.receiver
     *
     * @mbg.generated
     */
    public Integer getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.receiver
     *
     * @param receiver the value for message.receiver
     *
     * @mbg.generated
     */
    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.timestamp
     *
     * @return the value of message.timestamp
     *
     * @mbg.generated
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.timestamp
     *
     * @param timestamp the value for message.timestamp
     *
     * @mbg.generated
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.content
     *
     * @return the value of message.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.content
     *
     * @param content the value for message.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}