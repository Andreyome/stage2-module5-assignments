package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10000000000000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    private static List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(StringBuilder processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        stringArrayList.forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        if(stringList.size() !=0) {
            stringArrayList = new LinkedList<>(stringList);
            stringArrayList.forEach(str -> processorName.append(str).append(" "));
        }
            return String.valueOf(processorName);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file)  {

            try {
                informationScanner = new Scanner(file);
                while (informationScanner.hasNext()) {
                    if(informationScanner.nextLine() !=null) {
                        processorVersion.append(informationScanner.nextLine());
                    }
                }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            finally {
                informationScanner.close();
            }

    }
}
