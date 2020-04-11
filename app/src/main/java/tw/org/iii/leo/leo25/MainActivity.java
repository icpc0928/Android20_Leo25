package tw.org.iii.leo.leo25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private  DatabaseReference myRef , myRef2;
    private int i = 0;
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesg = findViewById(R.id.mesg);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.v("leo", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.v("leo", "Failed to read value.", error.toException());
            }
        });
    }

    public void test1(View view) {

        myRef.setValue("Hello, World!");


    }

    public void test2(View view) {
//        myRef2.setValue();
        myRef2 = database.getReference("member");
//        myRef2.addChildEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                Member obj = dataSnapshot.getValue(Member.class);
////                mesg.setText(""+obj.getAge());
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError databaseError) {
////
////            }
////        });





       Member member = new Member();
        member.setAge((int)(Math.random()*99));
        member.addName("Leo");
        member.addName("Brad");
        member.addName("Kevin");
        myRef2.setValue(member);

    }
}
