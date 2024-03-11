package com.example.translate;

public class MTToMXConverter {

    public static MXMessage convertMTToMX(MTMessage mtMessage) {
        MXMessage mxMessage = new MXMessage();

        // Phân tích tin nhắn MT và trích xuất thông tin cần thiết
        String[] messageParts = mtMessage.getBody().split("\n");
        String transactionReference = "";
        String senderReference = "";
        String receiverReference = "";
        String currency = "";
        String amount = "";
        String account = "";
        String text = "";

        for (String part : messageParts) {
            if (part.startsWith(":20:")) {
                transactionReference = part.substring(4);
            } else if (part.startsWith(":21:")) {
                senderReference = part.substring(4);
            } else if (part.startsWith(":25:")) {
                receiverReference = part.substring(4);
            } else if (part.startsWith(":32A:")) {
                currency = part.substring(7, 10);
                amount = part.substring(10);
            } else if (part.startsWith(":52A:")) {
                account = part.substring(4);
            } else if (part.startsWith(":72:")) {
                text = part.substring(4);
            }
        }

        // Tạo tin nhắn MX tương ứng
        StringBuilder mxBody = new StringBuilder();
        mxBody.append(":20:").append(transactionReference).append("\n");
        mxBody.append(":21:").append(senderReference).append("\n");
        mxBody.append(":25:").append(receiverReference).append("\n");
        mxBody.append(":32A:").append(currency).append(amount).append("\n");
        mxBody.append(":52A:").append(account).append("\n");
        mxBody.append(":72:").append(text);

        // Thiết lập tin nhắn MX
        mxMessage.setBody(mxBody.toString());

        return mxMessage;
    }
}
