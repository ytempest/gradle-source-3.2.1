package com.android.build.gradle.internal.transforms;

import com.android.build.api.transform.Status;
import com.android.build.api.transform.TransformException;
import java.io.IOException;

public abstract interface ChangeRecords$RecordHandler
{
  public abstract void handle(String paramString, Status paramStatus)
    throws IOException, TransformException;
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ChangeRecords.RecordHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */