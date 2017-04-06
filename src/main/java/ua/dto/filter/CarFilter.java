package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CarFilter {
	private static final Pattern PATTERN = Pattern.compile("[0-9]+");

	private String maxPrice = "";

	private String minPrice = "";
	private String minYear = "";
	private String maxYear = "";
	private Integer miniYear;
	private Integer maxiYear;
	private Integer max;
	private Integer min;

	private String search = "";
	private List<Integer> producerIds = new ArrayList<>();
	private List<Integer> modelIds = new ArrayList<>();
	private List<Integer> engineIds = new ArrayList<>();
	private List<Integer> gearBoxIds = new ArrayList<>();
	private List<Integer> countryIds = new ArrayList<>();
	private List<Integer> colorIds = new ArrayList<>();
	


	public Integer getMiniYear() {
		return miniYear;
	}

	public void setMiniYear(Integer miniYear) {
		this.miniYear = miniYear;
	}

	public Integer getMaxiYear() {
		return maxiYear;
	}

	public void setMaxiYear(Integer maxiYear) {
		this.maxiYear = maxiYear;
	}

	public List<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}

	public String getMinYear() {
		return minYear;
	}

	public void setMinYear(String minYear) {
		if (PATTERN.matcher(minYear).matches())
			miniYear = Integer.valueOf(minYear);
		this.minYear = minYear;
	}

	public String getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(String maxYear) {
		if (PATTERN.matcher(maxYear).matches())
			maxiYear = Integer.valueOf(maxYear);
		this.maxYear = maxYear;
	}

	public String getSearch() {
		return search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if (PATTERN.matcher(maxPrice).matches())
			max = Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if (PATTERN.matcher(minPrice).matches())
			min = Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {

		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}

	public List<Integer> getModelIds() {
		return modelIds;
	}

	public void setModelIds(List<Integer> modelIds) {
		this.modelIds = modelIds;
	}

	public List<Integer> getEngineIds() {
		return engineIds;
	}

	public void setEngineIds(List<Integer> engineIds) {
		this.engineIds = engineIds;
	}

	public List<Integer> getGearBoxIds() {
		return gearBoxIds;
	}

	public void setGearBoxIds(List<Integer> gearBoxIds) {
		this.gearBoxIds = gearBoxIds;
	}

	public List<Integer> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Integer> countryIds) {
		this.countryIds = countryIds;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
