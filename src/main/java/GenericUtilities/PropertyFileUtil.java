package GenericUtilities;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class PropertyFileUtil {
		/** this method reads data ffrom property file based on given key
		 * 
		 * @param string
		 * @return
		 * @throws IOException
		 */

		public String getDataFromPropertyFile(String key) throws IOException {
			FileInputStream fis = new FileInputStream(IConstants.propertyFile);
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
		}


	}



