package Blob;

import Game.*;

public class ExtremeBlobFactory extends BlobFactory {

   public ExtremeBlobFactory(){
       super();
       GameLoop.getInstance().setSpeed(150);
   }

   @Override
   public ABlob createBlob(Game game) {
       if(intUsedToCreateBlobs.isEmpty()) {
           fillIntArray();
           currentHP+=2;
        }
        int blobCaseValue = intUsedToCreateBlobs.remove(0);
        switch(blobCaseValue) {
            case 0:
                return blob(game);
            case 3:
                return bonusBlob(game);
            default:
                return poisonBlob(game);
        }
    }

}
