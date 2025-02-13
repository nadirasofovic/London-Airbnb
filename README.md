# London Airbnb - Assignment 

## Project Overview
This assignment revolves around helping Hazel, a traveler from far away, find suitable accommodation in London after his original booking was canceled due to an unfortunate accident involving a falling hazelnut tree.The goal is to identify three specific accommodations based on his preferences and constraints.

## Objectives
Hazel is looking for:
1. **The cheapest shared room** in London.
2. **The most expensive private room** within a **10-kilometer radius from Big Ben**.
3. **An accommodation located in the middle** of the list for all places that have "London" in their name.

## Data Source
The dataset for this project consists of Airbnb listings in London, containing details such as:
- **Room Type** (Shared room, Private room, Entire home/apartment)
- **Price**
- **Location (Latitude, Longitude)**
- **Name and Description**
- **Availability and Reviews**

## Implementation Details
The solution is implemented using **Java**, utilizing data structures and algorithms to efficiently filter and sort the listings based on Hazel's criteria.

### Key Steps:
1. **Load and parse Airbnb data** into appropriate data structures.
2. **Filter listings** based on room type, price, and location.
3. **Sort and extract** the required accommodations.
4. **Output the three selected options** in a user-friendly format.

## Expected Output
After running the program, Hazel will receive three recommendations:
- The **cheapest shared room**.
- The **most expensive private room** within a 10km radius from Big Ben.
- The **middle accommodation** from all listings containing "London" in their name.
