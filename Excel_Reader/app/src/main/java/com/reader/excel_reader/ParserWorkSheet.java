package com.reader.excel_reader;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.reader.excel_reader.adapter.RVWorkSheetItemAdapter;
import com.reader.excel_reader.models.WorkSheetModels;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ParserWorkSheet extends AppCompatActivity {

    private static final String TAG = "WorkSheet";
    private String pathToFile ;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser);
        pathToFile = getIntent().getStringExtra("path");
        file = new File(pathToFile);
        if (file.exists()){
            Toast.makeText(getApplicationContext(), "is downloaded", Toast.LENGTH_LONG).show();
            try {
                initRecyclerView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void initRecyclerView() throws Exception {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_lst_work_sheet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<WorkSheetModels> list = new ArrayList<>();
//        FileInputStream myInput = new FileInputStream(file);

        // Create a POIFSFileSystem object
//        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

        // Create a workbook using the File System
//        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

        // Get the first sheet from workbook
//        myWorkBook.getNumberOfSheets();
//        HSSFSheet mySheet = myWorkBook.getSheetAt(0);

        for (int i = 0; i < 5; i++) {
            WorkSheetModels models = new WorkSheetModels();
            models.setString(i + "");
//            models.setString(myWorkBook.getNumberOfSheets() + "");
            list.add(models);
        }
        recyclerView.setAdapter(new RVWorkSheetItemAdapter(list));


    }

//    private static void readExcelFile(Context context, String filename) {
//
////        if (!isExternalStorageAvailable() || isExternalStorageReadOnly())
////        {
////            Log.e(TAG, "Storage not available or read only");
////            return;
////        }
//
//        try{
//            // Creating Input Stream
//            File file = new File(context.getExternalFilesDir(null), filename);
//            FileInputStream myInput = new FileInputStream(file);
//
//            // Create a POIFSFileSystem object
//            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
//
//            // Create a workbook using the File System
//            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
//
//            // Get the first sheet from workbook
//            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
//
//            /** We now need something to iterate through the cells.**/
//            Iterator rowIter = mySheet.rowIterator();
//            while(rowIter.hasNext()){
//                HSSFRow myRow = (HSSFRow) rowIter.next();
//                Iterator cellIter = myRow.cellIterator();
//                while(cellIter.hasNext()){
//                    HSSFCell myCell = (HSSFCell) cellIter.next();
//                    Log.d(TAG, "Cell Value: " + myCell.toString());
//                    Toast.makeText(context, "cell Value: " + myCell.toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        }catch (Exception e){e.printStackTrace(); }
//
//        return;
//    }
}
